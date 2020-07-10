import React from 'react';
import Key from './../atoms/_key';
import { makeStyles } from '@material-ui/core/styles'

const useStyles = makeStyles((theme) => ({
    keyPad: {
        display: 'flex',
        flexDirection: 'column',
        margin: '3px',
    },
    keyRow: {
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'flex-end',
        flex: '1',
        width: '100%',
    }
})
)

const KeyPad = () => {
    const classes = useStyles();
    return (
        <div className={classes.keyPad}>
            <div className={classes.keyRow}>
                <Key value={"AC"} />
                <Key value={"<="} />
            </div>
            <div className={classes.keyRow}>
                <Key value={"7"} />
                <Key value={"8"} />
                <Key value={"9"} />
                <Key value={"/"} />
            </div>
            <div className={classes.keyRow}>
                <Key value={"4"} />
                <Key value={"5"} />
                <Key value={"6"} />
                <Key value={"*"} />
            </div>
            <div className={classes.keyRow}>
                <Key value={"1"} />
                <Key value={"2"} />
                <Key value={"3"} />
                <Key value={"+"} />
            </div>
            <div className={classes.keyRow}>
                <Key value={"0"} />
                <Key value={"."} />
                <Key value={"="} />
                <Key value={"-"} />
            </div>
        </div>
    )
}

export default KeyPad;