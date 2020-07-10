import React from 'react'
import CalculatorBody from './../organisms/_calculatorBody'
import { makeStyles } from '@material-ui/core/styles'

const useStyles = makeStyles({
    root: {
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        //background: 'linear-gradient(to bottom, white, #c2eafc)',
        //background: 'linear-gradient(to top, #1f1c2c, #928dab)',
        //backgroundColor: '#948E99',
        backgroundColor: '#403b4a',
        height: '100vh',
        width: '100%',
    }
})
const Calculator = () => {
    const classes = useStyles();
    return (
        <div className={classes.root}>
            <CalculatorBody />
        </div>
    )
}

export default Calculator;