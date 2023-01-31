## _TravelUA_

***

>__A web server application that has the following API:__

***

`POST <host>/travels` - adds travel to the list of user travels. Endpoint accepts JSON with the following data:
* `name` - is the travel name;
* `city` - is the city of the travel;
* `fromDate` -is the start date of the trip;
* `toDate` — is the end date of the trip;
* `price` — is an amount of money;
* `description` — is the travel description.

***

`GET <host>/travels` - shows the list of all travels grouped.

***

`GET <host>/travels/by/date` -  shows the list if all travels by date, where:
* `date` -  is the date for which all expenses should be showed.

***

`GET <host>/travels/by/date/to/date` - shows the list if all travels by date, where:
* `fromDate` -  is the start date for which all travels should be showed;
* `toDate` - is the end date for which all travels should be showed.

***

`GET <host>/travels/by/city` - shows the list if all travels by city, where:
* `city` - is the city of the travel.

***

`DELETE <host>/travels/date` - removes all travels for specified date, where:
* `date` -  is the date for which all expenses should be removed.

***

`DELETE <host>/travels/city` - removes all travels for specified city, where:
* `city` -  is the city for which all travels should be removed.

***
`PUT <host>/travels` - updates something or all in the travel by specified name. You must specify the name of the trip and any parameters, that should be changed, where:
* `name` - is the travel name;
* `name` - is the travel name, that should to update;
* `city` - is the city of the travel, that should to update;
* `fromDate` -is the start date of the trip, that should to update;
* `toDate` — is the end date of the trip, that should to update;
* `price` — is an amount of money, that should to update;
* `description` — is the travel description, that should to update.

***
