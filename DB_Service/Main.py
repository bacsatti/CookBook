from flask import Flask
from sqlalchemy import text
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from sqlalchemy.ext.declarative import declarative_base

engine = create_engine('mysql://root:root@localhost:3307/test_db')
_SessionFactory = sessionmaker(bind=engine)
Base = declarative_base()
app = Flask(__name__)

def session_factory():
    Base.metadata.create_all(engine)
    return _SessionFactory()

@app.route("/recipe")
def get_recipe():
    commit()
    test = engine.connect().execute(text("SELECT title, ingredients, process FROM some_table"))
    return test


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
