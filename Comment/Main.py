import requests
from Comment import Comment
import datetime

url = 'http://localhost:8080/comment/'

def get_comments(title):

    print("Get all the comments!")
    datas = requests.get(url+title).json()
    comments = [Comment]
    for data in datas:
        comments.append(Comment(data['username'], data['content'], data['date']))

    for comment in comments:
        print(comment)


def post_comment():
    print("post comment to database!")
    temp = Comment("Me","Phew, it pretty good!", datetime.datetime.now().strftime("%x"))
    payload = {
        'username': temp.username,
        'content': temp.content,
        'date': temp.date
    }
    print(requests.post(url+"add", json=payload).json())


post_comment()
get_comments("Pho")
