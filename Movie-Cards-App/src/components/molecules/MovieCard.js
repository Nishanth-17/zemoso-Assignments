import React from 'react';
import StarRating from '../atoms/StarRating';
import Rating from '../atoms/Rating';
import Poster from '../atoms/Poster';
import Title from '../atoms/Title';
import Genre from '../atoms/Genre';
import Description from '../atoms/Description';
import Release from '../atoms/Release';
import '../../styles/components/movieCard.css';
import Knight from '../../images/Dark_Knight.jpg';
import Titanic from '../../images/Titanic.jpg';
import Inception from '../../images/Inception.jpg';
import Endgame from '../../images/Endgame.jpg';
import Infinity_War from '../../images/Infinity.jpg';
import Avatar from '../../images/Avatar.jpg';
import Interstellar from '../../images/Interstellar.jpg';
import Joker from '../../images/Joker.jpg';
import Parasite from '../../images/Parasite.jpg';
import Dont_Breathe from '../../images/DontBreathe.jpg';
import Furious from '../../images/Furious7.jpg'; 
import Legend from '../../images/Legend.jpg';

const MovieCard = (props) => {
    let image=urlName(props);
    return(
    <div className="movie-card">
        <div className="movie-card card">
            <Poster image={image} />
            <div className="card-body">
                <Title title={props.movie.title} />
                <Genre genre={props.movie.genre} />
                <Release year={props.movie.year} />
                <Description description={props.movie.description} />
            </div>
            <div className="card-footer">
                    <div className="float-left mt-1">
                        <StarRating rating={props.movie.rating} />
                    </div>
                    <Rating rating={props.movie.rating} />
                </div>
            </div>
        </div>
    );
}

let urlName= (props) => {
    let name=props.movie.imageUrl;
    let image='';
    if(name==='Dark_Knight')
        image=Knight;
    else if(name==='Titanic')
        image=Titanic;
    else if(name==='Inception')
        image=Inception;
    else if(name==='Endgame')
        image=Endgame;
    else if(name==='Infinity_War')
        image=Infinity_War;
    else if(name==='Avatar')
        image=Avatar;
    else if(name==='Interstellar')
        image=Interstellar;
    else if(name==='Joker')
        image=Joker;
    else if(name==='Parasite')
        image=Parasite;
    else if(name==='Dont_Breathe')
        image=Dont_Breathe;
    else if(name==='Furious')
        image=Furious;
    else
        image=Legend;
    return image;
}

export default MovieCard;