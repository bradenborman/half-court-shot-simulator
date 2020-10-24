import React, { useState } from "react";
import classNames from "classnames";

require("./appContextMenu.scss");

export interface IMenuProps {
  children: any;
}

export const ContextMenu: React.FC<IMenuProps> = (props: IMenuProps) => {
  const [showMenu, setShowMenu] = useState<boolean>(false);
  const [xAxis, setxAxis] = useState<number>(0);
  const [yAxis, setyAxis] = useState<number>(0);

  const onMouseDown = (e: any) => {
    setShowMenu(false);
    document.removeEventListener("mousedown", onMouseDown);
  };

  const onContextMenu = (e: any) => {
    e.preventDefault();
    setxAxis(e.pageX);
    setyAxis(e.pageY);
    setShowMenu(true);
    document.addEventListener("mousedown", onMouseDown, false);
  };
  document.addEventListener("contextmenu", onContextMenu, false);

  const divStyle = { left: xAxis - 10 + "px", top: yAxis - 10 + "px" };

  const menuClasses = () => {
    return classNames("menu", { "menu-show": showMenu });
  };

  return (
    <div>
      <ul className={menuClasses()} style={divStyle}>
        {props.children}
      </ul>
    </div>
  );
};
