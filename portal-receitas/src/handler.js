export const handler = async (event) => {
  try {
    const backendUrl = "https://rdo5w5laxh.execute-api.us-east-1.amazonaws.com/prod/report";

    console.log("Chamando backend:", backendUrl);

    const res = await fetch(backendUrl);
    
    if (!res.ok) {
      throw new Error(`Erro ao acessar backend: ${res.status} ${res.statusText}`);
    }

    const data = await res.json();
    const total = data.length || 0;
    const media =
      total > 0 ? data.reduce((acc, item) => acc + (item.valor || 0), 0) / total : 0;

    const stats = {
      total_registros: total,
      media_valores: media,
    };

    console.log("Estatísticas geradas:", stats);

    return {
      statusCode: 200,
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(stats),
    };

  } catch (error) {
    console.error("Erro no Lambda:", error);

    return {
      statusCode: 500,
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        erro: error.message,
      }),
    };
  }
};
