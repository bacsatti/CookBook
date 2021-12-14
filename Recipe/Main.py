import requests
from flask import Flask
from flask import request

base_url = 'http://db-service:8080/recipe'
app = Flask(__name__)

@app.route('/')
def get_recipes():
    print('Get all the recipes!')
    datas = requests.get(f'{base_url}/').json()
    return {
        'statusCode': 200,
        'body': datas
    }


@app.route('/<int:recipe_id>')
def get_recipe(recipe_id):
    print('Get one specific recipe!')
    data = requests.get(f"{base_url}/{recipe_id}").json()

    return {
        'statusCode': 200,
        'body': data
    }


@app.route("/", methods=['POST'])
def post_recipe():
    print('post recipe to database!')
    form_data = request.json

    payload = {
        'title': form_data['title'],
        'process': form_data['process'],
        'ingredients': form_data['ingredients']
    }

    data = requests.post(base_url + '/add', json=payload).json()
    return {
        'statusCode': 200,
        'body': data
    }


if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5002)
