import requests
from flask import Flask
from flask import request
import datetime

base_url = 'http://db-service:8080/comment'
app = Flask(__name__)

@app.route('/', methods=['POST'])
def post_comment():
    print("post comment to database!")
    form_data = request.json
    payload = {
        'recipeId': form_data['recipeId'],
        'comment': form_data['comment'],
        'userName': form_data['userName']
    }
    data = requests.post(base_url + '/add', json=payload).json()
    print(data)
    return data

@app.route('/')
def hello():
    return 'Hello World!'


if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5001)