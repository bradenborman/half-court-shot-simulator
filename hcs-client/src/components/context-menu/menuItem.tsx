import React from "react";
import classNames from "classnames";

export interface IMenuItemProps {
  action?: () => void;
  iconClass?: string;
  disabled?: boolean;
  children: any;
}

export const MenuItem: React.FC<IMenuItemProps> = (props: IMenuItemProps) => {
  return (
    <li
      onClick={props.action}
      className={classNames("menu-item", {
        "menu-item-disabled": props.disabled
      })}
    >
      <a className="menu-btn">
        <i className={classNames("fa", props.iconClass)}></i>
        <span className="menu-text">{props.children}</span>
      </a>
    </li>
  );
};
