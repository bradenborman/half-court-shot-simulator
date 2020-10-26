export const openGoogle = (): void => {
  window.open("https://www.google.com");
};

export const reloadPage = (): void => {
  location.reload();
};

export const chatWithPat = (): void => {
  //<a href={`sip:<${user.email}>`}>@{user.fullName}</a>
  window.open("sip:PSteuber@ShelterInsurance.com");
};
