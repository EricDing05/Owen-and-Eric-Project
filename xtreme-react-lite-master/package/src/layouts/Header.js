import React from "react";
import { Link, useLocation } from "react-router-dom";
import {
  Navbar,
  Collapse,
  Nav,
  NavItem,
  NavbarBrand,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
  Dropdown,
  Button,
 Container,
  Row,
  Col,
} from "reactstrap";
import { ReactComponent as LogoWhite } from "../assets/images/logos/xtremelogowhite.svg";
import user1 from "../assets/images/users/user1.jpg";

const Header = () => {
  const [isOpen, setIsOpen] = React.useState(false);
  const [dropdownOpen, setDropdownOpen] = React.useState(false);

  const location = useLocation();

  const toggle = () => setDropdownOpen((prevState) => !prevState);
  const Handletoggle = () => {
    setIsOpen(!isOpen);
  };
  const showMobilemenu = () => {
    document.getElementById("sidebarArea").classList.toggle("showSidebar");
  };


  const getPageTitle = (pathname) => {
      switch (pathname) {
        case '/home':
          return 'Home';
        case '/newlist':
          return 'New Grocery List';
        case '/mylists':
          return 'My Lists';
        case '/contactus':
          return 'Contact Us';
        case '/myaccount':
          return 'My Account';
        case '/createaccount':
          return 'New Account';
        default:
          return '';
      }
    };

  const pageTitle = getPageTitle(location.pathname);


  return (
  <>
    <Navbar color="primary" dark expand="md">
      <div className="d-flex align-items-center w-100">
        <NavbarBrand href="/" className="d-lg-none">
          <LogoWhite />
        </NavbarBrand>
        <Button
          color="primary"
          className="d-lg-none"
          onClick={() => showMobilemenu()}
        >
          <i className="bi bi-list"></i>
        </Button>
        <div className="flex-grow-1 text-center">
                    <h3 className="text-white mb-0">{pageTitle}</h3>
                  </div>

      </div>
      <div className="hstack gap-2">
        <Button
          color="primary"
          size="sm"
          className="d-sm-block d-md-none"
          onClick={Handletoggle}
        >
          {isOpen ? (
            <i className="bi bi-x"></i>
          ) : (
            <i className="bi bi-three-dots-vertical"></i>
          )}
        </Button>
      </div>

      <Collapse navbar isOpen={isOpen}>
        <Nav className="me-auto" navbar>
          <NavItem>
          </NavItem>
          <NavItem>
          </NavItem>
        </Nav>
        <Dropdown isOpen={dropdownOpen} toggle={toggle}>
          <DropdownToggle color="primary">
            <img
              src={user1}
              alt="profile"
              className="rounded-circle"
              width="30"
            ></img>
          </DropdownToggle>
          <DropdownMenu>
            <DropdownItem header>Info</DropdownItem>

             <DropdownItem tag={Link} to="/myaccount">
                          My Account
                        </DropdownItem>
                        <DropdownItem tag={Link} to="/createaccount">
                          Create a New Account
                        </DropdownItem>
            <DropdownItem>Logout</DropdownItem>
          </DropdownMenu>
        </Dropdown>
      </Collapse>
    </Navbar>
    </>

  );
};

export default Header;
