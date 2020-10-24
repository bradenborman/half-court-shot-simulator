import React, { useState } from "react";
import classNames from "classnames";

require("./ContextMenu.scss");

export interface IMenuProps {
  children: any;
}

export const ContextMenu: React.FC<IMenuProps> = (props: IMenuProps) => {
  const [showMenu, setShowMenu] = useState<boolean>(false);
  const [xAxis, setxAxis] = useState<number>(0);
  const [yAxis, setyAxis] = useState<number>(0);

  const onMouseDown = (e: any) => {
    setShowMenu(false);
    document.removeEventListener("click", onMouseDown);
  };

  document.addEventListener(
    "contextmenu",
    (e: any) => {
      e.preventDefault();
      setxAxis(e.pageX);
      setyAxis(e.pageY);
      setShowMenu(true);
      document.addEventListener("click", onMouseDown, false);
    },
    false
  );

  return (
    <div>
      <ul
        className={classNames("menu", { "menu-show": showMenu })}
        style={{ left: xAxis - 10 + "px", top: yAxis - 10 + "px" }}
      >
        {props.children}
      </ul>
    </div>
  );
};
