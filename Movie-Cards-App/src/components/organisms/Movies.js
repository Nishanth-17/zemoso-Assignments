import React, { Component } from 'react';
import MovieList from './MovieList';
import MovieService from '../../services/MovieService';

export default class Movies extends Component {

    constructor() {
        super();
        this.state = {
            movies: []
        };
    }

    componentDidMount() {
        this.setState(() => ({ movies: MovieService.getMovies() }));
    }

    render() {  
        return (
            <div className="container-fluid" style={{marginLeft: '-15px'}}>
                        <MovieList movies={this.state.movies} />
            </div>
        );
    }
}