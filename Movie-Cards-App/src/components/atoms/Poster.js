import React from 'react';

const Poster =(props) => {
    return(
        <div>
            <img className="card-img-top" style={{width:"298px",height:"170px"}} src={props.image} alt="" />
        </div>
    );
}
export default Poster;