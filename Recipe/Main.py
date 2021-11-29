import requests

r = requests.get('http://127.0.0.1:5000/recipe')
print(r.text)