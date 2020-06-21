package net.runelite.client.plugins.banktabnames;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ScriptID;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "BankTabNames",
	description = "Customize the names of your bank tabs",
	tags = {"nickname", "custom", "edit"}
)

public class BankTabNamesPlugin extends Plugin
{
	private String tab1Name;
	private String tab2Name;
	private String tab3Name;
	private String tab4Name;
	private String tab5Name;
	private String tab6Name;
	private String tab7Name;
	private String tab8Name;
	private String tab9Name;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private BankTabNamesConfig config;

	private static final int TAB_MAX_LENGTH = 15;

	@Provides
	BankTabNamesConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BankTabNamesConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		log.debug("Start");
		save();
		replaceBankTabNumbers();
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.debug("Stop");
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		save();
		System.out.println("Saving Banktab Names...");
		replaceBankTabNumbers();
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired scriptPostFired)
	{
		if (scriptPostFired.getScriptId() == ScriptID.TOPLEVEL_REDRAW)
		{
			log.debug("Finished TopLevel Redraw");
		}
		if (scriptPostFired.getScriptId() == 276)
		{
			log.debug("Bank Reloaded!");
			replaceBankTabNumbers();
		}
		if (scriptPostFired.getScriptId() == 504)
		{
			replaceBankTabNumbers();
		}
	}

	private void replaceBankTabNumbers()
	{

		final Widget bankTabCont = client.getWidget(WidgetInfo.BANK_TAB_CONTAINER);

		if (bankTabCont != null)
		{
			TabFonts bankFont = config.bankFont();
			TabFonts bankFont2 = config.bankFont2();
			TabFonts bankFont3 = config.bankFont3();
			TabFonts bankFont4 = config.bankFont4();
			TabFonts bankFont5 = config.bankFont5();
			TabFonts bankFont6 = config.bankFont6();
			TabFonts bankFont7 = config.bankFont7();
			TabFonts bankFont8 = config.bankFont8();
			TabFonts bankFont9 = config.bankFont9();

			String tabNameText = config.tab1Name();
			if (bankFont.name().equals("FAIRY_SMALL") || bankFont.name().equals("FAIRY_LARGE"))
			{
				tabNameText = tabNameText.toUpperCase();

			}
			String tabNameText2 = config.tab2Name();
			if (bankFont2.name().equals("FAIRY_SMALL") || bankFont2.name().equals("FAIRY_LARGE"))
			{
				tabNameText2 = tabNameText2.toUpperCase();

			}
			String tabNameText3 = config.tab3Name();
			if (bankFont3.name().equals("FAIRY_SMALL") || bankFont3.name().equals("FAIRY_LARGE"))
			{
				tabNameText3 = tabNameText3.toUpperCase();

			}
			String tabNameText4 = config.tab4Name();
			if (bankFont4.name().equals("FAIRY_SMALL") || bankFont4.name().equals("FAIRY_LARGE"))
			{
				tabNameText4 = tabNameText4.toUpperCase();

			}
			String tabNameText5 = config.tab5Name();
			if (bankFont5.name().equals("FAIRY_SMALL") || bankFont5.name().equals("FAIRY_LARGE"))
			{
				tabNameText5 = tabNameText5.toUpperCase();

			}
			String tabNameText6 = config.tab6Name();
			if (bankFont6.name().equals("FAIRY_SMALL") || bankFont6.name().equals("FAIRY_LARGE"))
			{
				tabNameText6 = tabNameText6.toUpperCase();

			}
			String tabNameText7 = config.tab7Name();
			if (bankFont7.name().equals("FAIRY_SMALL") || bankFont7.name().equals("FAIRY_LARGE"))
			{
				tabNameText7 = tabNameText7.toUpperCase();

			}
			String tabNameText8 = config.tab8Name();
			if (bankFont8.name().equals("FAIRY_SMALL") || bankFont8.name().equals("FAIRY_LARGE"))
			{
				tabNameText8 = tabNameText8.toUpperCase();

			}
			String tabNameText9 = config.tab9Name();
			if (bankFont9.name().equals("FAIRY_SMALL") || bankFont9.name().equals("FAIRY_LARGE"))
			{
				tabNameText9 = tabNameText9.toUpperCase();

			}


			bankTabCont.getChild(11).setText(tabNameText);
			bankTabCont.getChild(12).setText(tabNameText2);
			bankTabCont.getChild(13).setText(tabNameText3);
			bankTabCont.getChild(14).setText(tabNameText4);
			bankTabCont.getChild(15).setText(tabNameText5);
			bankTabCont.getChild(16).setText(tabNameText6);
			bankTabCont.getChild(17).setText(tabNameText7);
			bankTabCont.getChild(18).setText(tabNameText8);
			bankTabCont.getChild(19).setText(tabNameText9);


			bankTabCont.getChild(11).setTextColor(config.bankFontColor().getRGB());
			bankTabCont.getChild(12).setTextColor(config.bankFontColor2().getRGB());
			bankTabCont.getChild(13).setTextColor(config.bankFontColor3().getRGB());
			bankTabCont.getChild(14).setTextColor(config.bankFontColor4().getRGB());
			bankTabCont.getChild(15).setTextColor(config.bankFontColor5().getRGB());
			bankTabCont.getChild(16).setTextColor(config.bankFontColor6().getRGB());
			bankTabCont.getChild(17).setTextColor(config.bankFontColor7().getRGB());
			bankTabCont.getChild(18).setTextColor(config.bankFontColor8().getRGB());
			bankTabCont.getChild(19).setTextColor(config.bankFontColor9().getRGB());


			bankTabCont.getChild(11).setFontId(bankFont.tabFontId);
			bankTabCont.getChild(12).setFontId(bankFont2.tabFontId);
			bankTabCont.getChild(13).setFontId(bankFont3.tabFontId);
			bankTabCont.getChild(14).setFontId(bankFont4.tabFontId);
			bankTabCont.getChild(15).setFontId(bankFont5.tabFontId);
			bankTabCont.getChild(16).setFontId(bankFont6.tabFontId);
			bankTabCont.getChild(17).setFontId(bankFont7.tabFontId);
			bankTabCont.getChild(18).setFontId(bankFont8.tabFontId);
			bankTabCont.getChild(19).setFontId(bankFont9.tabFontId);

		}
	}

	private void save()
	{
		config.bankFont();
		config.tab1Name();
		config.tab2Name();
		config.tab3Name();
		config.tab4Name();
		config.tab5Name();
		config.tab6Name();
		config.tab7Name();
		config.tab8Name();
		config.tab9Name();

		config.bankFontColor();
		config.bankFontColor2();
		config.bankFontColor3();
		config.bankFontColor4();
		config.bankFontColor5();
		config.bankFontColor6();
		config.bankFontColor7();
		config.bankFontColor8();
		config.bankFontColor9();

		config.bankFont();
		config.bankFont2();
		config.bankFont3();
		config.bankFont4();
		config.bankFont5();
		config.bankFont6();
		config.bankFont7();
		config.bankFont8();
		config.bankFont9();
	}
}
