import React from 'react';

const Rating =(props) => {
    return(
        <div className="card-footer-badge float-right badge badge-primary badge-pill">
        {props.rating}
        </div>
    );
}
export default Rating;