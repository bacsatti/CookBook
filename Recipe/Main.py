import requests
from ..DB_Service.Main import session_factory
from .Recipe import Recipe

r = requests.get('http://127.0.0.1:5000/recipe')

print(r.text)
def get_recipe():
    session = session_factory()
    people_query = session.query(Recipe)
    session.close()
    return people_query.all()

def create_recipe():
    session = session_factory()
    Pho = Recipe("Pho", [
                "jo",
                "sok",
                "minden"
            ], "Dobald ossze, oszt fozzed")
    session.add(Pho)
    session.commit()
    session.close()

if __name__ == "__main__":
    recipes = get_recipe()
    if len(recipes) == 0:
        create_recipe()
    recipes = get_recipe()

    for recipe in recipes:
        print("{recipe.title} \n{recipe.ingredients}\n {recipe.process}")