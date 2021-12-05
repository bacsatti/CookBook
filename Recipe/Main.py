import requests
from Recipe import Recipe
datas = requests.get('http://localhost:8080/recipe/').json()

recipes = [Recipe]
for data in datas:
    recipes.append(Recipe(data['title'], data['ingredients'], data['process']))

for recipe in recipes:
    print(recipe)
