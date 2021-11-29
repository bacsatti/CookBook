from flask import Flask

app = Flask(__name__)

@app.route("/recipe")
def getRecipe():

    test = {"title": "Pho",
            "ingredients": [
                "jo",
                "sok",
                "minden"
            ],
            "process": "Dobald ossze, oszt fozzed"}
    return test

@app.route("/comments")
def getComments():

    return "patent"