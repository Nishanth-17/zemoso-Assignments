import React from 'react';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles({
    root: {
        display: 'flex',
        flexFlow: 'row wrap',
        justifyContent:'center',
    },
    searchBar: {
        display: 'block',
        width: 200,
        padding: 15,
        boxShadow: '3px 6px rgba(0,0,0,0.2)',
        background: 'transparent',
        backgroundColor: 'rgba(255,255,255,0.75)',
        borderRadius: '16px 16px 16px 16px',
        color: 'gray',
        fontSize: 20,
        transition: '0.4s ease',
    },
    ForecastButton: {
        display: 'inlineBlock',
        width: 150,
        height: 57,
        fontSize: 20,
        fontWeight: 'bold',
        color: 'white',
        marginLeft: 20,
        paddingTop: 10,
        paddingBottom: 10,
        paddingRight: 10,
        background: 'transparent',
        borderRadius: '16px 16px 16px 16px',
        '&:hover':{
            backgroundColor: 'rgba(255,255,255,0.10)',
            boxShadow: '3px 6px rgba(0,0,0,0.2)',
            cursor: 'pointer'
        }
    }
})
const Form = (props) => {
    const classes = useStyles();
    return (
        <div>
            <form onSubmit={props.submitQuery} className={classes.root}>

                <input className={classes.searchBar}
                    type="text"
                    name="city"
                    placeholder="Enter City..."
                />
                <button className={classes.ForecastButton} type="submit">Get Forecast</button>
            </form>
        </div>
    )
}
export default Form;
