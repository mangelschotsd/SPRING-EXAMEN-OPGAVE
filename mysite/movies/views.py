# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render

from django.http import HttpResponse

import redis

r = redis.StrictRedis(host='localhost', port=6379, db=0)

def index(request):
    movies = r.keys
    return render(request, 'movies/index.html', {'movies': movies})

def search(request):
    if request.method == 'POST':
        movie = request.POST.get('movie')
        if len(movie) == 0:
            return render(request, 'movies/search.html', {'actors': 'You have to give a movie title'})

        actors = r.get(movie)

        return render(request, 'movies/search.html', {'actors': actors} )
    else:
        return render(request, 'movies/search.html', None)
