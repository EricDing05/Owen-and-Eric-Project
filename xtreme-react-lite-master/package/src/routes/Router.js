import { lazy } from "react";
import { Navigate } from "react-router-dom";
/****Layouts*****/
const FullLayout = lazy(() => import("../layouts/FullLayout.js"));

/***** Pages ****/
const About = lazy(() => import("../views/About.js"));
const Alerts = lazy(() => import("../views/ui/Alerts"));
const Badges = lazy(() => import("../views/ui/Badges"));
const Buttons = lazy(() => import("../views/ui/Buttons"));
const Grid = lazy(() => import("../views/ui/Grid"));
const Forms = lazy(() => import("../views/ui/Forms"));
const Breadcrumbs = lazy(() => import("../views/ui/Breadcrumbs"));
const NewList = lazy(() => import("../views/ui/NewList"));
const MyLists = lazy(() => import("../views/ui/MyLists")); // made a route for myList page
const Home = lazy(() => import("../views/ui/Home")); // made a route for myList page
const ReportABug = lazy(() => import("../views/ui/ReportABug")); // made a route for myList page
const CreateAccount = lazy(() => import("../views/ui/CreateAccount"));
const MyAccount = lazy(() => import("../views/ui/MyAccount"));
const Login = lazy(() => import("../views/ui/Login"));
const SearchList = lazy(() => import("../views/ui/SearchList"));


/*****Routes******/

const ThemeRoutes = [
  {
    path: "/",
    element: <FullLayout />,
    children: [
      { path: "/", element: <Navigate to="/Home" /> },
      { path: "/about", exact: true, element: <About /> },
      { path: "/alerts", exact: true, element: <Alerts /> },
      { path: "/badges", exact: true, element: <Badges /> },
      { path: "/buttons", exact: true, element: <Buttons /> },
      { path: "/grid", exact: true, element: <Grid /> },
      { path: "/forms", exact: true, element: <Forms /> },
      { path: "/breadcrumbs", exact: true, element: <Breadcrumbs /> },
      { path: "/newlist", exact: true, element: <NewList /> },
      { path: "/mylists", element: <MyLists /> }, // added mylists here
      { path: "/home", element: <Home /> }, // added mylists here
      { path: "/reportabug", element: <ReportABug /> },
      { path: "/createaccount", element: <CreateAccount /> },
      { path: "/myaccount", element: <MyAccount /> },
      { path: "/login", element: <Login /> },
      { path: "/searchlist", element: <SearchList /> }
    ],
  },
];

export default ThemeRoutes;
