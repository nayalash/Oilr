# Oilr
Oilr is a discord bot, using the JDA and MyGasFeed API to deliver gas prices based on the Longitude and Latitude of your location.

## Commands

* GET information regarding the discord bot.

```
!help
```

* CONGIGURE Longitude, Latitude and Radius(miles) values

```
!config (LATITUDE) (LONGITUDE) (RADIUS)

Example:

!config 41.965462 87.654800 5
```

* Send Back Gas Prices and Location of Gas Station based on configured values.

```
!fetchPrice
```

Example Use

```
> !config 41.965462 87.654800 5
> !fetchPrice

Log

The Current Gas Price In Your Area is: $3.19

The Location of the Gas Station near you is 4000 W Peterson Ave

```

## Deployment

Port A Discord Bot To a Server Of Your Choice (see [link](https://github.com/DV8FromTheWorld/JDA/wiki/3)-Getting-Started) for details)

Clone Repository
Install Dependencies 
Run Gradle Bot.Main()


## Built With

* [JDA](https://github.com/DV8FromTheWorld/JDA) - Discord API Wrapper
* [MyGasFeed API](http://www.mygasfeed.com/keys/intro) - Gas Feed API 
* [Gradle](https://gradle.org/) - Dependency Management
* [org.json](http://stleary.github.io/JSON-java/index.html) - JSON Parsing Tool

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* [scarger](https://github.com/scarger) Omar Elnagmi, Programming Mentor. Helped with parsing HTTP - JSON. 

## READ.md Template

* [PurpleBooth](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2#file-readme-template-md)

