import React from 'react';
import {create} from 'react-test-renderer'
import "@testing-library/jest-dom/extend-expect";
import { render, screen, getByRole, fireEvent } from "@testing-library/react";
import Poster from './Poster'

test("Match the snapshot - Poster",() => {
    const input=create(<Poster />);
    expect(input.toJSON()).toMatchSnapshot();
})

test("Image is present", () => {
    render(<Poster/>);
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
