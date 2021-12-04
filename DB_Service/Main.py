from flask import Flask
from sqlalchemy import text
from database.database_base import session_factory
import database.modell.Recipe as Recipe

app = Flask(__name__)

@app.route("/recipe")
def get_recipe():
    session=session_factory()
    response = session.query(Recipe)
    session.close()
    return response

@app.route("/comments")
def get_comments():
    return "patent"


def commit():
    with engine.connect() as conn:
        #conn.execute(text("CREATE TABLE some_table (x int, y int)"))
        conn.execute(
            text("INSERT INTO some_table (title, ingredients, process) VALUES (:title, :ingredients, :process)"),
            [{"title": "Pho",
              "ingredients": [
                  "jo",
                  "sok",
                  "minden"
              ],
              "process": "Dobald ossze, oszt fozzed"}]
        )
        conn.commit()
if __name__ == "__main__":
    app.run()