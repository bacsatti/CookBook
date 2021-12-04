from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from sqlalchemy.ext.declarative import declarative_base

engine = create_engine('mysql://root:root@localhost:3307/test_db')
_SessionFactory = sessionmaker(bind=engine)
Base = declarative_base()

def session_factory():
    print("creating session_factory...")
    Base.metadata.create_all(engine)
    return _SessionFactory()