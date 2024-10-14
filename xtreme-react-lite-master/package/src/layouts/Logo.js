import { Link } from "react-router-dom";
import { ReactComponent as LogoDark } from "../assets/images/logos/groceryGuruLogo.svg";

const Logo = () => {
  return (
    <Link to="/" style={{ display: 'flex', alignItems: 'center' }}>
      <LogoDark style={{ width: '190px', height: 'auto', display: 'block' }} />
    </Link>
  );
};

export default Logo;
