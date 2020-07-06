import React from 'react';
import {create} from 'react-test-renderer'
import "@testing-library/jest-dom/extend-expect";
import { render, screen, getByRole, fireEvent } from "@testing-library/react";
import MovieCard from './MovieCard'
import Description from '../atoms/Description/Description';


const movie1=
    {
        "id": 100,
        "title": "Avengers: Endgame",
        "genre": "Action/Sci-Fi",
        "description":"After Thanos, an intergalactic warlord, disintegrates half of the universe, the Avengers must reunite and assemble again to reinvigorate their trounced allies and restore balance.",
        "year": 2019,
        "imageUrl": "Endgame",
        "videoId": "hA6hldpSTF8",
        "rating": 4.9
    }
const movie2=

    {
        "id": 200,
        "title": "Joker",
        "genre": "Drama/Crime",
        "description": "Isolated, bullied and disregarded by society, Fleck begins a slow descent into madness as he transforms into the criminal mastermind known as the Joker.",
        "year": 2019,
        "imageUrl": "Joker",
        "videoId": "zAGVQLHvwOY",
        "rating": 4.7
    }
const movie3=
    {
        "id": 300,
        "title": "Parasite",
        "genre": "Thriller/Comedy",
        "description": "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.",
        "year": 2019,
        "imageUrl": "Parasite",
        "videoId": "SEUXfv87Wpk",
        "rating": 4.7
    }
const movie4=
    {
        "id":400,
        "title": "Avengers: Infinity War",
        "genre": "Action/Sci-Fi",
        "description": "The Avengers must stop Thanos, an intergalactic warlord, from getting his hands on all the infinity stones. However, Thanos is prepared to go to any lengths to carry out his insane plan.",
        "year": 2018,
        "imageUrl":"Infinity_War",
        "videoId": "6ZfuNTqbHE8",
        "rating":4.4
    }
const movie5=
    {
        "id": 500,
        "title": "Don't Breathe",
        "genre": "Horror/Thriller",
        "description": "Three delinquents break into the house of Norman, who is blind, to steal his money. However, much to their horror, they discover that Norman is not as defenceless as he seems.",
        "year": 2016,
        "imageUrl": "Dont_Breathe",
        "videoId": "76yBTNDB6vU",
        "rating": 3.9
    }
const movie6={
    "id": 600,
    "title": "Furious 7",
    "genre": "Action/Thriller",
    "description": "Dominic and his family are caught in a quagmire when Shaw's brother seeks bloody revenge. They must save a crucial program from falling into the wrong hands.",
    "year": 2015,
    "imageUrl": "Furious",
    "videoId": "Skpu5HaVkOc",
    "rating": 4.1
}

jest.mock('../atoms/Title/Title',() => ({
    __esModule: true,
    default: () => { return <div></div>}
    }))
jest.mock('../atoms/Description/Description',() => ({
    __esModule: true,
    default: () => { return <div></div>}
}))
jest.mock('../atoms/Genre/Genre',() => ({
    __esModule: true,
    default: () => { return <div></div>}
}))
jest.mock('../atoms/Header/Header',() => ({
    __esModule: true,
    default: () => { return <div></div>}
}))
jest.mock('../atoms/Poster/Poster',() => ({
    __esModule: true,
    default: () => { return <div></div>}
}))
jest.mock('../atoms/Rating/Rating',() => ({
    __esModule: true,
    default: () => { return <div></div>}
}))
jest.mock('../atoms/Release/Release',() => ({
    __esModule: true,
    default: () => { return <div></div>}
}))
jest.mock('../atoms/SearchBar/SearchBar',() => ({
    __esModule: true,
    default: () => { return <div></div>}
}))
jest.mock('../atoms/StarRating/StarRating',() => ({
    __esModule: true,
    default: () => { return <div></div>}
}))
test("Match the snapshot - MovieCard 1",() => {
    const input=create(<MovieCard movie={movie1}/> );
    expect(input.toJSON()).toMatchSnapshot();
})
test("Match the snapshot - MovieCard 2",() => {
    const input=create(<MovieCard movie={movie2}/> );
    expect(input.toJSON()).toMatchSnapshot();
})
test("Match the snapshot - MovieCard 3",() => {
    const input=create(<MovieCard movie={movie3}/> );
    expect(input.toJSON()).toMatchSnapshot();
})
test("Match the snapshot - MovieCard 4",() => {
    const input=create(<MovieCard movie={movie4}/> );
    expect(input.toJSON()).toMatchSnapshot();
})
test("Match the snapshot - MovieCard 5",() => {
    const input=create(<MovieCard movie={movie5}/> );
    expect(input.toJSON()).toMatchSnapshot();
})

test("Match the snapshot - MovieCard 6",() => {
    const input=create(<MovieCard movie={movie6}/> );
    expect(input.toJSON()).toMatchSnapshot();
})
/*
test("Image is present", () => {
    render(<MovieCard/>);
    const image=screen.getByAltText("movie-poster");
    expect(image).toBeInTheDocument();

})
test("Video is popping up", () => {
    const {getByRole, getByTestId} = render(<Poster/>)
    fireEvent.click(getByRole('button'))
    expect(getByTestId('modal')).toBeInTheDocument();
})
test("Button is present", () => {
    render(<Poster/>);
    const button = screen.getByRole("button");
    expect(button).toBeInTheDocument();
  });
*/