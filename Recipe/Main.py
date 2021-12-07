import requests
from Recipe import Recipe

url = 'http://localhost:8080/recipe/'


def get_recipes():

    print("Get all the recipes!")
    datas = requests.get(url).json()
    recipes = [Recipe]
    for data in datas:
        recipes.append(Recipe(data['title'], data['ingredients'], data['process']))

    for recipe in recipes:
        print(recipe)


def get_recipe(title):
    print("Get one specific recipe!")
    data = requests.get(url+title).json()
    print(data)


def post_recipe():
    print("post recipe to database!")
    temp = Recipe("Sajtostangli",["sajt","tangli"], "Whatever cause i can't eat it.")
    payload = {
        'title': temp.title,
        'process': temp.process,
        'ingredients': temp.ingredients
    }
    print(requests.post(url+"add", json=payload).json())


get_recipes()
get_recipe("Pho")
post_recipe()
get_recipe("Sajtostangli")
