import React from 'react';
import { Button, Typography } from '@material-ui/core';
import { useDispatch } from 'react-redux'
import { myTheme } from "../../theme";
import { makeStyles } from '@material-ui/core/styles'

const useStyles = makeStyles((theme) => ({
    root: {
        height: "4em",
        width: "7.6em",
        margin: "8px",
        backgroundColor: myTheme.palette.primary.main,
        color: 'white',
        '&:hover': {
            backgroundColor: myTheme.palette.primary.light
        }
    },
    actionButton: {
        height: "4em",
        width: "7.6em",
        margin: "8px",
        color: 'white',
        backgroundColor: myTheme.palette.secondary.main,
        '&:hover': {
            backgroundColor: myTheme.palette.secondary.light
        }
    },
    text: {
        fontSize: 24,
        fontWeight: 'bold'
    }
})
)
const Key = (props) => {
    const classes = useStyles();
    const dispatch = useDispatch();
    return (
        <div>
            <Button
                className={((props.value === "AC" || props.value === "<=" || props.value === "+" || props.value === "-" || props.value === "*" || props.value === "/")
                    ? classes.actionButton : classes.root)}
                variant='contained'
                onClick={() => {
                    dispatch({ type: props.value, value: props.value })
                }}
            >
                <Typography className={classes.text} variant='button'>{props.value}</Typography>
            </Button>
        </div>
    )

}

export default Key;