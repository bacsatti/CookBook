from sqlalchemy import Column, String
from sqlalchemy.sql import base
from sqlalchemy.sql.sqltypes import Integer
from ..database_base import Base

class Recipe(Base):
    __tablename__: "Recipe"

    id=Column(Integer, primary_key=True)
    title=Column('title', String)
    ingredients=Column('ingredients', String)
    process=Column('process', String)

    def __init__(self, title, ingredients, process):
        self.title = title
        self.ingredients = ingredients
        self.process = process