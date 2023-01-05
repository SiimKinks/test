## Introduction
Product owner asks to show all customer accounts details on screen.
During first development iteration user must be able to see account
name and for savings account goal image.
Interviewer is your teammate, who is already working on the project for quite a while.
He can advise you on technical solutions. Therefore, feel free to communicate with him and ask for help.

## Description
* Create new `UseCase` named `ObserveAccountDetails` which gathers all
required information from repositories.
* Use created use case in `AccountDetailsPresenter` which should prepare the data for rendering (actual rendering _not_ to be implemented)

## Tech requirements
* Code must be written in kotlin
* Cover code with tests

## Notes
* Repositories signature cannot be changed
* Imagine that dependencies are provided with dependency injection