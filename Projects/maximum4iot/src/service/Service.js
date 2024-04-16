import React from "react";
import useGoogleSheets from "use-google-sheets";

function Service(num) {
  let data = React.useMemo(
    () => [
      {
        Description: "Loading...",
        RelatedNFR: "Loading...",
        MeasurementFunction: "Loading...",
        Interpretation: "Loading...",
        CollectMethod: "Loading...",
        Reference: "Loading...",
      },
    ],
    []
  );

  const {
    data: sheetData,
    loading,
    error,
  } = useGoogleSheets({
    apiKey: process.env.REACT_APP_GOOGLE_API_KEY,
    sheetId: process.env.REACT_APP_GOOGLE_SHEETS_ID,
  });

  if (loading) {
    console.log("Loading...");
  } else {
    data = sheetData[num]["data"];
  }

  if (error) {
    console.log("Error!");
  }

  return data;
}

export default Service;
