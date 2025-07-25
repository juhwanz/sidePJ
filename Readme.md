psutil : 자원 간단히 수집 (크로스 플랫폼)

time : sleep으로 일정 주기마다 실행
requests : HTTP Post로 Collector API호출
json : json 직렬화용
socket : gethostname()으로 host명을 자동으로 넘겨줌

$ python agent.py
✅ Sent: {'host': 'ubuntu', 'cpu': 32.1, 'memory': 58.2, 'disk': 61.9} | 🔁 Response: 200
