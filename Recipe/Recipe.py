class Recipe:
    def __init__(self, title, ingredients, process):
        self.title = title
        self.ingredients = ingredients
        self.process = process

    def __str__(self):      # self
        return "{},{},{}".format(self.title, self.ingredients, self.process)