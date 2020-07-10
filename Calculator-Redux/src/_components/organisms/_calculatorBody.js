import React from 'react'
import InputBox from './../atoms/_inputBox'
import KeyPad from './../molecules/_keyPad'
import { makeStyles } from '@material-ui/core/styles'
import { Typography } from '@material-ui/core'

const useStyles = makeStyles({
    root: {
        height: 'auto',
        width: '500px',
        borderRadius: '10px',
        boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.5), 0 6px 20px 0 rgba(0, 0, 0, 0.5)',
        backgroundColor: 'white'
    },
    text: {
        textAlign: 'center',
        fontWeight: 'bold',
        fontFamily: `Roboto, Helvetica, "Arial", sans-serif`
    }
})
const CalculatorBody = () => {
    const classes = useStyles();
    return (
        <div className={classes.root}><br />
            <Typography className={classes.text} variant="h4" >CALCULATOR APP</Typography><br />
            <InputBox />
            <KeyPad />
        </div>
    )
}

export default CalculatorBody;