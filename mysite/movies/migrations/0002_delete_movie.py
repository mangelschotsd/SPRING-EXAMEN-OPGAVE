# -*- coding: utf-8 -*-
# Generated by Django 1.11.10 on 2018-09-06 13:40
from __future__ import unicode_literals

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('movies', '0001_initial'),
    ]

    operations = [
        migrations.DeleteModel(
            name='Movie',
        ),
    ]
