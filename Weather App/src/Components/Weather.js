import React, { Component, useState, useEffect } from 'react';
import axios from 'axios';
import { Typography } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';
import Form from './Form'

const api_key = "21ab4dd7b6d836e1b7e198a2c5cbffc6";
const useStyles = makeStyles({
    root: {
        background: 'linear-gradient(45deg, #FE6B8B 30%, #FF8E53 90%)',
        border: 0,
        borderRadius: 3,
        boxShadow: '0 3px 5px 2px rgba(255, 105, 135, .3)',
        color: 'white',
        height: 700,
        paddingTop: 1,
    },
    rootCool: {
        background: 'linear-gradient(45deg, gray 30%, lightblue 90%)',
        border: 0,
        borderRadius: 3,
        boxShadow: '0 3px 5px 2px rgba(255, 105, 135, .3)',
        color: 'white',
        height: 700,
        paddingTop: 1,
    },
    rootWarm: {
        background: 'linear-gradient(45deg, red 30%, orange 90%)',
        border: 0,
        borderRadius: 3,
        boxShadow: '0 3px 5px 2px rgba(255, 105, 135, .3)',
        color: 'white',
        height: 700,
        paddingTop: 1,
    },
    weatherBox: {
        textAlign: 'center',
        position: "relative",
        display: "inline-block",
        marginTop: 20,
        backgroundColor: 'rgba(255,255,255,0.2)',
        borderRadius: 16,
        padding: '20px 80px 20px 80px',
        color: 'white',
        textShadow: '3px 6px rgba(50,50,70,0.5)',
        boxShadow: '3px 6px rgba(0,0,0,0.2)'
    },


})
const Weather = () => {

    const [weather, setWeather] = useState({})
    const [query, setQuery] = useState({
        q: 'Hyderabad'
    })

    useEffect(() => {
        axios.get(`http://api.openweathermap.org/data/2.5/weather?q=${query.q}&appid=${api_key}`)
            .then(response => {
                console.log(response)
                setWeather(
                    {
                        city: response.data.name,
                        country: response.data.sys.country,
                        celsius: calculateTemp(response.data.main.temp),
                        temp_max: calculateTemp(response.data.main.temp_max),
                        temp_min: calculateTemp(response.data.main.temp_min),
                        description: response.data.weather[0].main,
                    })
            })
    }, [query])

    const calculateTemp = (temp) => {
        let temperatureInCelsius = Math.floor(temp - 273.15);
        return temperatureInCelsius;
    }

    const getForecast = (e) => {
        e.preventDefault();
        setQuery({
            q: e.target.elements.city.value
        })
    }
    const classes = useStyles();
    return (
        <div className={
            (weather.celsius < 30) ?
                ((weather.celsius < 20) ?
                    ((weather.celsius > 0) ? classes.rootCool : classes.root)
                    : classes.root)
                : classes.rootWarm}
            style={{ textAlign: 'center' }}
        >
            <br /><br /><Typography variant="h2">Weather Forecast App</Typography>   <br />
            <Form submitQuery={getForecast} /><br />
            <Typography variant="h2">{weather.city}, {weather.country}</Typography><br />
            <div className={classes.weatherBox}>
                <Typography variant="h2">{weather.celsius} &deg;C</Typography><br />
                <Typography variant="h3">{weather.description}</Typography><br />
                <Typography variant="h3">{weather.temp_max + 3} &deg;C &nbsp; {weather.temp_min - 2} &deg;C</Typography>
            </div>
        </div>
    )
}
export default Weather;
