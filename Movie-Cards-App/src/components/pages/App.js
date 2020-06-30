import React from 'react';
import Header from '../atoms/Header';
import Movies from '../organisms/Movies';

const App = () =>  {

        return (
            <div>
                <Header title="Movie Cards" />
                <div className="mt-5">
                    <Movies />
                </div>
            </div>
        );
}
export default App;