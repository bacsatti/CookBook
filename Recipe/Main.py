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


def get_recipe():
    print("Get one specific recipe!")
    temp = "Pho"
    data = requests.get(url+temp).json()

    print(data)


def put_recipe():
    print("putting recipe in database!")


get_recipes()
get_recipe()
