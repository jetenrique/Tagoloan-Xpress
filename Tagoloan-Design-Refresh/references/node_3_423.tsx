const assetPathPrefix = "https://www.figma.com/api/mcp/asset/30322e08-0a55-42f1-a16f-f0efe7f11617";
const imgContainer = `${assetPathPrefix}/5f578.svg`;
const imgContainer1 = `${assetPathPrefix}/9812a.svg`;
const imgContainer2 = `${assetPathPrefix}/f1263.svg`;
const imgIconBack = `${assetPathPrefix}/82c1c.svg`;
const imgIconFood = `${assetPathPrefix}/5aa2a.svg`;
const imgIconCart = `${assetPathPrefix}/11944.svg`;
const imgIconPill = `${assetPathPrefix}/608ea.svg`;
const imgIconBook = `${assetPathPrefix}/1084b.svg`;
const imgIconPkg = `${assetPathPrefix}/6c50b.svg`;
const imgIconDots = `${assetPathPrefix}/bc4a7.svg`;
const imgIconMinus = `${assetPathPrefix}/74930.svg`;
const imgIconPlus = `${assetPathPrefix}/222ba.svg`;
const imgIconCash = `${assetPathPrefix}/58f99.svg`;
const imgIconWallet = `${assetPathPrefix}/d41b3.svg`;
const imgIconArrow = `${assetPathPrefix}/76d20.svg`;

export default function CreatePasugoStep1() {
  return (
    <div className="bg-[#fbf9f1] relative size-full" data-node-id="3:423" data-name="create pasugo step 1">
      <div className="absolute bg-[#fbf9f1] content-stretch flex flex-col items-start left-0 overflow-clip top-0 w-[390px]" data-node-id="124:244" data-name="Screen">
        <div className="content-stretch flex h-[24px] items-center justify-between px-[16px] relative shrink-0 w-full" data-node-id="124:245" data-name="Container">
          <div className="content-stretch flex flex-col items-start relative shrink-0" data-node-id="124:246" data-name="Container">
            <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:SemiBold'] font-semibold justify-center leading-[0] relative shrink-0 text-[#18181f] text-[11px] tracking-[0.5px] whitespace-nowrap" data-node-id="124:247">
              <p className="leading-[16px]">9:41</p>
            </div>
          </div>
          <div className="content-stretch flex gap-[4px] items-center relative shrink-0" data-node-id="124:248" data-name="Container">
            <div className="relative shrink-0 size-[11.667px]" data-node-id="124:249" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer} />
            </div>
            <div className="h-[9.917px] relative shrink-0 w-[14px]" data-node-id="124:251" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer1} />
            </div>
            <div className="h-[11.667px] relative shrink-0 w-[5.833px]" data-node-id="124:253" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer2} />
            </div>
          </div>
        </div>
        <div className="content-stretch flex gap-[12px] items-center overflow-clip px-[16px] py-[8px] relative shrink-0 w-full" data-node-id="124:255" data-name="App bar">
          <a className="bg-white border border-[#ece8df] border-solid content-stretch cursor-pointer flex items-center justify-center overflow-clip relative rounded-[20px] shrink-0 size-[40px]" data-node-id="124:256" data-name="Back button">
            <div className="relative shrink-0 size-[18px]" data-node-id="124:257" data-name="icon/back">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconBack} />
            </div>
          </a>
          <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col items-start leading-[1.35] min-w-px overflow-clip relative" data-node-id="124:259" data-name="Container">
            <p className="font-['Plus_Jakarta_Sans:Bold'] font-bold relative shrink-0 text-[#18181f] text-[18px] w-full" data-node-id="124:260">
              Create Pasugo
            </p>
            <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="124:261">
              Step 1 of 4 · Item details
            </p>
          </div>
        </div>
        <div className="content-stretch flex items-start overflow-clip px-[16px] py-[4px] relative shrink-0 w-full" data-node-id="124:263" data-name="Progress">
          <div className="bg-[#ece8df] content-stretch flex flex-[1_0_0] h-[6px] items-start min-w-px overflow-clip relative rounded-[999px]" data-node-id="124:264" data-name="Container">
            <div className="bg-[#febc20] h-[6px] relative rounded-[999px] shrink-0 w-[90px]" data-node-id="124:265" data-name="Rectangle" />
          </div>
        </div>
        <div className="content-stretch flex flex-col gap-[28px] items-start overflow-clip p-[16px] relative shrink-0 w-full" data-node-id="124:266" data-name="Body">
          <div className="content-stretch flex flex-col gap-[12px] items-start overflow-clip relative shrink-0 w-full" data-node-id="124:267" data-name="Category">
            <div className="content-stretch flex items-center overflow-clip relative shrink-0 w-full" data-node-id="124:268" data-name="Section title">
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] min-w-px relative text-[#18181f] text-[16px]" data-node-id="124:269">
                What do you need?
              </p>
            </div>
            <div className="content-stretch flex gap-[10px] items-start overflow-clip relative shrink-0 w-full" data-node-id="124:270" data-name="Container">
              <div className="bg-[#fff7e0] border-[#febc20] border-[1.5px] border-solid content-stretch flex flex-[1_0_0] flex-col gap-[8px] items-center min-w-px overflow-clip py-[16px] relative rounded-[14px]" data-node-id="124:271" data-name="Category – Food">
                <div className="relative shrink-0 size-[22px]" data-node-id="124:272" data-name="icon/food">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconFood} />
                </div>
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] min-w-full relative shrink-0 text-[#6b4e00] text-[13px] text-center w-[min-content]" data-node-id="124:276">
                  Food
                </p>
              </div>
              <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-[1_0_0] flex-col gap-[8px] items-center min-w-px overflow-clip py-[16px] relative rounded-[14px]" data-node-id="124:277" data-name="Category – Groceries">
                <div className="relative shrink-0 size-[22px]" data-node-id="124:278" data-name="icon/cart">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconCart} />
                </div>
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.35] min-w-full relative shrink-0 text-[#18181f] text-[13px] text-center w-[min-content]" data-node-id="124:282">
                  Groceries
                </p>
              </div>
              <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-[1_0_0] flex-col gap-[8px] items-center min-w-px overflow-clip py-[16px] relative rounded-[14px]" data-node-id="124:283" data-name="Category – Essentials">
                <div className="relative shrink-0 size-[22px]" data-node-id="124:284" data-name="icon/pill">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconPill} />
                </div>
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.35] min-w-full relative shrink-0 text-[#18181f] text-[13px] text-center w-[min-content]" data-node-id="124:287">
                  Essentials
                </p>
              </div>
            </div>
            <div className="content-stretch flex gap-[10px] items-start overflow-clip relative shrink-0 w-full" data-node-id="124:288" data-name="Container">
              <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-[1_0_0] flex-col gap-[8px] items-center min-w-px overflow-clip py-[16px] relative rounded-[14px]" data-node-id="124:289" data-name="Category – Supplies">
                <div className="relative shrink-0 size-[22px]" data-node-id="124:290" data-name="icon/book">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconBook} />
                </div>
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.35] min-w-full relative shrink-0 text-[#18181f] text-[13px] text-center w-[min-content]" data-node-id="124:292">
                  Supplies
                </p>
              </div>
              <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-[1_0_0] flex-col gap-[8px] items-center min-w-px overflow-clip py-[16px] relative rounded-[14px]" data-node-id="124:293" data-name="Category – Parcel">
                <div className="relative shrink-0 size-[22px]" data-node-id="124:294" data-name="icon/pkg">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconPkg} />
                </div>
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.35] min-w-full relative shrink-0 text-[#18181f] text-[13px] text-center w-[min-content]" data-node-id="124:298">
                  Parcel
                </p>
              </div>
              <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-[1_0_0] flex-col gap-[8px] items-center min-w-px overflow-clip py-[16px] relative rounded-[14px]" data-node-id="124:299" data-name="Category – Other">
                <div className="relative shrink-0 size-[22px]" data-node-id="124:300" data-name="icon/dots">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconDots} />
                </div>
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.35] min-w-full relative shrink-0 text-[#18181f] text-[13px] text-center w-[min-content]" data-node-id="124:304">
                  Other
                </p>
              </div>
            </div>
          </div>
          <div className="content-stretch flex flex-col gap-[14px] items-start overflow-clip relative shrink-0 w-full" data-node-id="124:305" data-name="Item details">
            <div className="content-stretch flex items-center overflow-clip relative shrink-0 w-full" data-node-id="124:306" data-name="Section title">
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] min-w-px relative text-[#18181f] text-[16px]" data-node-id="124:307">
                Item details
              </p>
            </div>
            <div className="content-stretch flex flex-col gap-[6px] items-start overflow-clip relative shrink-0 w-full" data-node-id="124:308" data-name="Field – Item name">
              <div className="content-stretch flex items-center overflow-clip relative shrink-0 w-full" data-node-id="124:309" data-name="Container">
                <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.35] min-w-px relative text-[#18181f] text-[13px]" data-node-id="124:310">
                  Item name
                </p>
              </div>
              <div className="bg-white border border-[#ece8df] border-solid content-stretch flex h-[48px] items-center overflow-clip px-[14px] relative rounded-[12px] shrink-0 w-full" data-node-id="124:311" data-name="Input">
                <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-px relative text-[#18181f] text-[15px]" data-node-id="124:312">
                  Minute Burger
                </p>
              </div>
            </div>
            <div className="content-stretch flex items-center overflow-clip relative shrink-0 w-full" data-node-id="124:313" data-name="Quantity">
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.35] min-w-px relative text-[#18181f] text-[13px]" data-node-id="124:314">
                Quantity
              </p>
              <div className="bg-white border border-[#ece8df] border-solid content-stretch flex gap-[16px] items-center overflow-clip p-[6px] relative rounded-[999px] shrink-0" data-node-id="124:315" data-name="Stepper">
                <div className="bg-[#f3f1ea] content-stretch flex items-center justify-center overflow-clip relative rounded-[15px] shrink-0 size-[30px]" data-node-id="124:316" data-name="Container">
                  <div className="relative shrink-0 size-[14px]" data-node-id="124:317" data-name="icon/minus">
                    <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconMinus} />
                  </div>
                </div>
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#18181f] text-[15px] whitespace-nowrap" data-node-id="124:319">
                  2
                </p>
                <div className="bg-[#febc20] content-stretch flex items-center justify-center overflow-clip relative rounded-[15px] shrink-0 size-[30px]" data-node-id="124:320" data-name="Container">
                  <div className="relative shrink-0 size-[14px]" data-node-id="124:321" data-name="icon/plus">
                    <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconPlus} />
                  </div>
                </div>
              </div>
            </div>
            <div className="content-stretch flex flex-col gap-[6px] items-start overflow-clip relative shrink-0 w-full" data-node-id="124:323" data-name="Field – Notes for the rider">
              <div className="[word-break:break-word] content-stretch flex items-center leading-[1.35] overflow-clip relative shrink-0 w-full" data-node-id="124:324" data-name="Container">
                <p className="flex-[1_0_0] font-['Plus_Jakarta_Sans:Medium'] font-medium min-w-px relative text-[#18181f] text-[13px]" data-node-id="124:325">
                  Notes for the rider
                </p>
                <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#a3a3ab] text-[12px] whitespace-nowrap" data-node-id="124:326">
                  Optional
                </p>
              </div>
              <div className="bg-white border border-[#ece8df] border-solid content-stretch flex h-[84px] items-start overflow-clip pt-[14px] px-[14px] relative rounded-[12px] shrink-0 w-full" data-node-id="124:327" data-name="Input">
                <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-px relative text-[#18181f] text-[15px]" data-node-id="124:328">
                  No onions, please.
                </p>
              </div>
            </div>
            <div className="content-stretch flex flex-col gap-[6px] items-start overflow-clip relative shrink-0 w-full" data-node-id="124:329" data-name="Field – Estimated budget">
              <div className="content-stretch flex items-center overflow-clip relative shrink-0 w-full" data-node-id="124:330" data-name="Container">
                <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.35] min-w-px relative text-[#18181f] text-[13px]" data-node-id="124:331">
                  Estimated budget
                </p>
              </div>
              <div className="[word-break:break-word] bg-white border border-[#ece8df] border-solid content-stretch flex gap-[10px] h-[48px] items-center leading-[1.35] overflow-clip px-[14px] relative rounded-[12px] shrink-0 text-[15px] w-full" data-node-id="124:332" data-name="Input">
                <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#6b6b73] whitespace-nowrap" data-node-id="124:333">
                  ₱
                </p>
                <p className="flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal min-w-px relative text-[#18181f]" data-node-id="124:334">
                  200
                </p>
              </div>
            </div>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="124:335">
              The rider pays first and shows you the store receipt.
            </p>
          </div>
          <div className="content-stretch flex flex-col gap-[12px] items-start overflow-clip relative shrink-0 w-full" data-node-id="124:336" data-name="Payment">
            <div className="content-stretch flex items-center overflow-clip relative shrink-0 w-full" data-node-id="124:337" data-name="Section title">
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] min-w-px relative text-[#18181f] text-[16px]" data-node-id="124:338">
                Payment
              </p>
            </div>
            <div className="bg-[#fff7e0] border-[#febc20] border-[1.5px] border-solid content-stretch flex gap-[12px] items-center overflow-clip p-[14px] relative rounded-[14px] shrink-0 w-full" data-node-id="124:339" data-name="Option – Cash on delivery">
              <div className="bg-white content-stretch flex items-center justify-center overflow-clip relative rounded-[10px] shrink-0 size-[36px]" data-node-id="124:340" data-name="Container">
                <div className="relative shrink-0 size-[18px]" data-node-id="124:341" data-name="icon/cash">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconCash} />
                </div>
              </div>
              <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col gap-[2px] items-start leading-[1.35] min-w-px overflow-clip relative" data-node-id="124:345" data-name="Container">
                <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] text-[14px] w-full" data-node-id="124:346">
                  Cash on delivery
                </p>
                <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="124:347">
                  Pay the rider on drop-off
                </p>
              </div>
              <div className="bg-white border-6 border-[#febc20] border-solid relative rounded-[10px] shrink-0 size-[20px]" data-node-id="124:348" data-name="Container" />
            </div>
            <div className="bg-white border border-[#ece8df] border-solid content-stretch flex gap-[12px] items-center overflow-clip p-[14px] relative rounded-[14px] shrink-0 w-full" data-node-id="124:349" data-name="Option – GCash">
              <div className="bg-[#f3f1ea] content-stretch flex items-center justify-center overflow-clip relative rounded-[10px] shrink-0 size-[36px]" data-node-id="124:350" data-name="Container">
                <div className="relative shrink-0 size-[18px]" data-node-id="124:351" data-name="icon/wallet">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconWallet} />
                </div>
              </div>
              <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col gap-[2px] items-start leading-[1.35] min-w-px overflow-clip relative" data-node-id="124:354" data-name="Container">
                <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] text-[14px] w-full" data-node-id="124:355">
                  GCash
                </p>
                <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="124:356">{`Send to the rider's GCash`}</p>
              </div>
              <div className="bg-white border-[#ece8df] border-[1.5px] border-solid relative rounded-[10px] shrink-0 size-[20px]" data-node-id="124:357" data-name="Container" />
            </div>
          </div>
          <a className="bg-[#febc20] content-stretch cursor-pointer flex gap-[8px] items-center justify-center overflow-clip py-[15px] relative rounded-[14px] shrink-0 w-full" data-node-id="124:358" data-name="Button – Continue">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#18181f] text-[15px] text-left whitespace-nowrap" data-node-id="124:359">
              Continue
            </p>
            <div className="relative shrink-0 size-[16px]" data-node-id="124:360" data-name="icon/arrow">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconArrow} />
            </div>
          </a>
        </div>
      </div>
    </div>
  );
}
