FROM python:latest

ADD . /code
WORKDIR /code

# We copy just the requirements.txt first to leverage Docker cache
COPY . /code

RUN pip install -r requirement.txt

CMD python /code/Main.py