import React from 'react';

const Description =(props) => {
    return(
        <p className="text-justify" style={{fontSize: '14px'}}>
            {props.description}
        </p>
    );
}
export default Description;