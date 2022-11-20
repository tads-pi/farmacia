package farmacia.view.interfaces;

import farmacia.view.libs.mysql.dao.ItemVendaDAO;
import farmacia.view.libs.mysql.dao.SellingsHistoryDAO;

public interface IReportsPanel {
    public SellingsHistoryDAO vendasDao = new SellingsHistoryDAO();
    public ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
}
