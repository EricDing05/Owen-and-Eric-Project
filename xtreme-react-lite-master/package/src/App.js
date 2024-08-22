import { useRoutes } from "react-router-dom";
import Themeroutes from "./routes/Router";
import React, { useEffect } from 'react';
import { getSessionId } from './utils';

const App = () => {
    useEffect(() => {
      getSessionId();  // Generate and store the session ID when the app loads
     }, []);
  const routing = useRoutes(Themeroutes);

  return <div className="dark">{routing}</div>;
};

export default App;
