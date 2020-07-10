import React from 'react';
import { useSelector } from 'react-redux';
import { makeStyles } from '@material-ui/core/styles'

const useStyles = makeStyles({
    root: {
        height: '2.1em',
        display: 'flex',
        justifyContent: 'flex-end',
        backgroundColor: 'transparent',
        alignItems: 'center',
        border: '2px solid gray',
        marginLeft: '12px',
        marginRight: '10px',
        borderRadius: '5px',
        fontSize: 25,
        fontWeight: 'bold',
        paddingRight: '12px',

    }
})
const InputBox = () => {
    const classes = useStyles();
    const inputValue = useSelector((state) => state);
    return (
        <div className={classes.root}>
            {inputValue}
        </div>
    )
}

export default InputBox;