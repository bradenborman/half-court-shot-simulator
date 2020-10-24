import React, { useState } from "react";
import classNames from "classnames";

require("./appContextMenu.scss");

export interface IMenuProps {
  updateSpeed: (newTime: number) => void;
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

  const divStyle = { left: xAxis + "px", top: yAxis + "px" };

  const menuClasses = () => {
    return classNames("menu", { "menu-show": showMenu });
  };

  return (
    <div>
      <ul className={menuClasses()} style={divStyle}>
        <li className="menu-item">
          <a href="#" className="menu-btn">
            <i className="fa fa-folder-open"></i>
            <span className="menu-text">Open</span>
          </a>
        </li>
        <li className="menu-item menu-item-disabled">
          <button type="button" className="menu-btn">
            <span className="menu-text">Open in New Window</span>
          </button>
        </li>
        <li className="menu-separator"></li>
        <li className="menu-item">
          <button
            type="button"
            onClick={() => props.updateSpeed(-0.5)}
            className="menu-btn"
          >
            <i className="fa fa-arrow-left"></i>
            <span className="menu-text">Slower</span>
          </button>
        </li>
        <li className="menu-item">
          <button type="button" className="menu-btn">
            <i className="fa fa-arrow-right"></i>
            <span className="menu-text">Faster</span>
          </button>
        </li>
        <li className="menu-separator"></li>
        <li className="menu-item">
          <button type="button" className="menu-btn">
            <i className="fa fa-reply"></i>
            <span className="menu-text">Reply</span>
          </button>
        </li>
        <li className="menu-item">
          <button type="button" className="menu-btn">
            <i className="fa fa-star"></i>
            <span className="menu-text">Favorite</span>
          </button>
        </li>
        <li className="menu-item menu-item-submenu">
          <button type="button" className="menu-btn">
            <i className="fa fa-users"></i>
            <span className="menu-text">Social</span>
          </button>
          <ul className="menu">
            <li className="menu-item">
              <button type="button" className="menu-btn">
                <i className="fa fa-comment"></i>
                <span className="menu-text">Comment</span>
              </button>
            </li>
            <li className="menu-item menu-item-submenu">
              <button type="button" className="menu-btn">
                <i className="fa fa-share"></i>
                <span className="menu-text">Share</span>
              </button>
              <ul className="menu">
                <li className="menu-item">
                  <button type="button" className="menu-btn">
                    <i className="fa fa-twitter"></i>
                    <span className="menu-text">Twitter</span>
                  </button>
                </li>
                <li className="menu-item">
                  <button type="button" className="menu-btn">
                    <i className="fa fa-facebook-official"></i>
                    <span className="menu-text">Facebook</span>
                  </button>
                </li>
                <li className="menu-item">
                  <button type="button" className="menu-btn">
                    <i className="fa fa-google-plus"></i>
                    <span className="menu-text">Google Plus</span>
                  </button>
                </li>
                <li className="menu-item">
                  <button type="button" className="menu-btn">
                    <i className="fa fa-envelope"></i>
                    <span className="menu-text">Email</span>
                  </button>
                </li>
              </ul>
            </li>
          </ul>
        </li>
        <li className="menu-separator"></li>
        <li className="menu-item">
          <button type="button" className="menu-btn">
            <i className="fa fa-download"></i>
            <span className="menu-text">Save</span>
          </button>
        </li>
        <li className="menu-item">
          <button type="button" className="menu-btn">
            <i className="fa fa-edit"></i>
            <span className="menu-text">Rename</span>
          </button>
        </li>
        <li className="menu-item">
          <button type="button" className="menu-btn">
            <i className="fa fa-trash"></i>
            <span className="menu-text">Delete</span>
          </button>
        </li>
      </ul>
    </div>
  );
};
