import psutil
import time
import requests
import json
from datetime import datetime
import socket
import requests


#호환 경로는 실제 Spring Boot APi 맞춰야함
#나중에 .env파일로 분리 가능
#임시
Collector_Url = "http://localhost:8080/api/resource/report"

# 서버가 열려있는지 확인하는 코드
def isServerOn(url):
  try : 
    response = requests.get(url)
    return response.status_code<500 # 200~499면 살아있다고 봄
  except:
    return False
if not isServerOn("http://localhost:8080/actuator/health"): #actuator 등록되어 있으여함.
  print("서버 다이. 서버 시작 요망")
  exit()
def collect_metrics():
  return {
    "id" : socket.gethostname(),
    "timestamp" : datetime.utcnow().isoformat(),
    "cpu" : psutil.cpu_percent(interval=1), # 1초 동안 측정
    "memory" : psutil.virtual_memory().percent, # 전체 메모리 사용률
    "disk" : psutil.disk_usage("/").percent # 루트 디렉토리 기준 디스크 사용률
  }

#전송 루프
while True:
  try:
    data = collect_metrics()
    r = requests.post(Collector_Url, json=data)
    print("Send: ", data, " | Response: ", r.status_code)
  except Exception as e:
    print("Sending Error: ", e)
  time.sleep(5)