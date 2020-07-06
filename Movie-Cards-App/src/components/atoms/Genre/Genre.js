import React from 'react';

const Genre =(props) => {
    return(
        <h6 className="card-subtitle mb-2 text-muted">
            {props.genre}
        </h6>
    );
}
export default Genre;