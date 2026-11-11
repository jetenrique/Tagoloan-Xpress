const assetPathPrefix = "https://www.figma.com/api/mcp/asset/25f2ecd2-249d-4d67-81d0-dcb08e3887a8";
const imgPhoto = `${assetPathPrefix}/6d05a.png`;
const imgContainer = `${assetPathPrefix}/5f578.svg`;
const imgContainer1 = `${assetPathPrefix}/9812a.svg`;
const imgContainer2 = `${assetPathPrefix}/f1263.svg`;
const imgIconBack = `${assetPathPrefix}/82c1c.svg`;
const imgIconPhone = `${assetPathPrefix}/6414b.svg`;
const imgIconFood = `${assetPathPrefix}/ac89b.svg`;
const imgIconSignal = `${assetPathPrefix}/4a110.svg`;
const imgIconPlus = `${assetPathPrefix}/8a963.svg`;
const imgIconSend = `${assetPathPrefix}/c98d8.svg`;

export default function ChatWithRiderInApp() {
  return (
    <div className="bg-[#fbf9f1] relative shadow-[0px_25px_50px_-12px_rgba(0,0,0,0.25)] size-full" data-node-id="3:5251" data-name="chat with rider in app">
      <div className="absolute bg-[#fbf9f1] content-stretch flex flex-col h-[844px] items-start left-0 overflow-clip top-0 w-[390px]" data-node-id="134:3" data-name="Screen">
        <div className="content-stretch flex h-[24px] items-center justify-between px-[16px] relative shrink-0 w-full" data-node-id="134:4" data-name="Container">
          <div className="content-stretch flex flex-col items-start relative shrink-0" data-node-id="134:5" data-name="Container">
            <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:SemiBold'] font-semibold justify-center leading-[0] relative shrink-0 text-[#18181f] text-[11px] tracking-[0.5px] whitespace-nowrap" data-node-id="134:6">
              <p className="leading-[16px]">9:41</p>
            </div>
          </div>
          <div className="content-stretch flex gap-[4px] items-center relative shrink-0" data-node-id="134:7" data-name="Container">
            <div className="relative shrink-0 size-[11.667px]" data-node-id="134:8" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer} />
            </div>
            <div className="h-[9.917px] relative shrink-0 w-[14px]" data-node-id="134:10" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer1} />
            </div>
            <div className="h-[11.667px] relative shrink-0 w-[5.833px]" data-node-id="134:12" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer2} />
            </div>
          </div>
        </div>
        <div className="bg-white border-[#ece8df] border-b border-solid content-stretch flex gap-[12px] items-center overflow-clip px-[16px] py-[10px] relative shrink-0 w-full" data-node-id="134:15" data-name="Chat header">
          <a className="bg-white border border-[#ece8df] border-solid content-stretch cursor-pointer flex items-center justify-center overflow-clip relative rounded-[20px] shrink-0 size-[40px]" data-node-id="134:16" data-name="Icon button">
            <div className="relative shrink-0 size-[18px]" data-node-id="134:17" data-name="icon/back">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconBack} />
            </div>
          </a>
          <div className="relative shrink-0 size-[40px]" data-node-id="134:14" data-name="Photo">
            <img alt="" className="absolute block inset-0 max-w-none size-full" height="40" src={imgPhoto} width="40" />
          </div>
          <div className="content-stretch flex flex-[1_0_0] flex-col items-start min-w-px overflow-clip relative" data-node-id="134:19" data-name="Container">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] min-w-full relative shrink-0 text-[#18181f] text-[15px] w-[min-content]" data-node-id="134:20">
              Juan Dela Cruz
            </p>
            <div className="content-stretch flex gap-[6px] items-center overflow-clip relative shrink-0" data-node-id="134:21" data-name="Container">
              <div className="bg-[#1e9e5a] relative rounded-[4px] shrink-0 size-[7px]" data-node-id="134:22" data-name="Container" />
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.4] relative shrink-0 text-[#6b6b73] text-[12px] whitespace-nowrap" data-node-id="134:23">
                Rider · Online
              </p>
            </div>
          </div>
          <div className="bg-[#febc20] content-stretch flex items-center justify-center overflow-clip relative rounded-[20px] shrink-0 size-[40px]" data-node-id="134:24" data-name="Icon button">
            <div className="relative shrink-0 size-[18px]" data-node-id="134:25" data-name="icon/phone">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconPhone} />
            </div>
          </div>
        </div>
        <div className="bg-[#fbf9f1] border-[#ece8df] border-b border-solid content-stretch flex gap-[10px] items-center overflow-clip px-[16px] py-[10px] relative shrink-0 w-full" data-node-id="134:28" data-name="Order strip">
          <div className="bg-[#fff7e0] content-stretch flex items-center justify-center overflow-clip relative rounded-[8px] shrink-0 size-[28px]" data-node-id="134:29" data-name="Container">
            <div className="relative shrink-0 size-[14px]" data-node-id="134:30" data-name="icon/food">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconFood} />
            </div>
          </div>
          <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.4] min-w-px relative text-[#6b6b73] text-[12px]" data-node-id="134:34">
            #TGX-8921 · Minute Burger
          </p>
          <div className="bg-[#e6f5ec] content-stretch flex items-center overflow-clip px-[10px] py-[4px] relative rounded-[999px] shrink-0" data-node-id="134:35" data-name="Chip">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#1e9e5a] text-[12px] whitespace-nowrap" data-node-id="134:36">
              Active
            </p>
          </div>
        </div>
        <div className="content-stretch flex flex-col gap-[18px] items-start overflow-clip p-[16px] relative shrink-0 w-full" data-node-id="134:37" data-name="Messages">
          <div className="content-stretch flex items-start justify-center overflow-clip relative shrink-0 w-full" data-node-id="134:38" data-name="Container">
            <div className="bg-[#f3f1ea] content-stretch flex items-center overflow-clip px-[10px] py-[4px] relative rounded-[999px] shrink-0" data-node-id="134:39" data-name="Chip">
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#6b6b73] text-[12px] whitespace-nowrap" data-node-id="134:40">
                Today, 11:15 AM
              </p>
            </div>
          </div>
          <div className="content-stretch flex items-start overflow-clip relative shrink-0 w-full" data-node-id="134:41" data-name="Message – received">
            <div className="content-stretch flex flex-col gap-[4px] items-start overflow-clip relative shrink-0" data-node-id="134:42" data-name="Container">
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#6b6b73] text-[11px] whitespace-nowrap" data-node-id="134:43">
                Juan · Rider
              </p>
              <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col items-start overflow-clip px-[14px] py-[10px] relative rounded-bl-[16px] rounded-br-[16px] rounded-tl-[4px] rounded-tr-[16px] shrink-0" data-node-id="134:44" data-name="Bubble">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.4] relative shrink-0 text-[#18181f] text-[14px] w-[250px]" data-node-id="134:45">
                  Sir Neil, naa nako sa Minute Burger Poblacion. Purchasing your order.
                </p>
              </div>
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.4] relative shrink-0 text-[#a3a3ab] text-[11px] whitespace-nowrap" data-node-id="134:46">
                11:16 AM
              </p>
            </div>
          </div>
          <div className="content-stretch flex items-start justify-end overflow-clip relative shrink-0 w-full" data-node-id="134:47" data-name="Message – sent">
            <div className="content-stretch flex flex-col gap-[4px] items-end overflow-clip relative shrink-0" data-node-id="134:48" data-name="Container">
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#6b6b73] text-[11px] whitespace-nowrap" data-node-id="134:49">
                You
              </p>
              <div className="bg-[#febc20] content-stretch flex flex-col items-start overflow-clip px-[14px] py-[10px] relative rounded-bl-[16px] rounded-br-[16px] rounded-tl-[16px] rounded-tr-[4px] shrink-0" data-node-id="134:50" data-name="Bubble">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.4] relative shrink-0 text-[#18181f] text-[14px] w-[250px]" data-node-id="134:51">
                  Please make sure no onions on the double cheeseburger. Thank you!
                </p>
              </div>
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.4] relative shrink-0 text-[#a3a3ab] text-[11px] whitespace-nowrap" data-node-id="134:52">
                11:17 AM
              </p>
            </div>
          </div>
        </div>
        <div className="flex-[1_0_0] min-h-px relative w-full" data-node-id="134:53" data-name="Flexible space" />
        <div className="content-stretch flex flex-col items-start overflow-clip px-[16px] py-[12px] relative shrink-0 w-full" data-node-id="134:54" data-name="Container">
          <div className="content-stretch flex flex-col gap-[8px] items-start overflow-clip relative shrink-0 w-full" data-node-id="134:55" data-name="Quick replies">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#6b6b73] text-[12px] whitespace-nowrap" data-node-id="134:56">
              Quick replies
            </p>
            <div className="content-start flex flex-wrap gap-[8px] items-start overflow-clip relative shrink-0 w-full" data-node-id="134:57" data-name="Container">
              <div className="bg-white border border-[#ece8df] border-solid content-stretch flex items-start overflow-clip px-[12px] py-[8px] relative rounded-[999px] shrink-0" data-node-id="134:58" data-name="Container">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.4] relative shrink-0 text-[#18181f] text-[13px] whitespace-nowrap" data-node-id="134:59">
                  Add extra ketchup
                </p>
              </div>
              <div className="bg-white border border-[#ece8df] border-solid content-stretch flex items-start overflow-clip px-[12px] py-[8px] relative rounded-[999px] shrink-0" data-node-id="134:60" data-name="Container">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.4] relative shrink-0 text-[#18181f] text-[13px] whitespace-nowrap" data-node-id="134:61">
                  How much is the total?
                </p>
              </div>
              <div className="bg-white border border-[#ece8df] border-solid content-stretch flex items-start overflow-clip px-[12px] py-[8px] relative rounded-[999px] shrink-0" data-node-id="134:62" data-name="Container">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.4] relative shrink-0 text-[#18181f] text-[13px] whitespace-nowrap" data-node-id="134:63">
                  I’m at the gate
                </p>
              </div>
            </div>
          </div>
        </div>
        <div className="bg-[#fff7e0] border-[#ece8df] border-solid border-t content-stretch flex gap-[10px] items-center overflow-clip px-[16px] py-[10px] relative shrink-0 w-full" data-node-id="134:64" data-name="SMS banner">
          <div className="relative shrink-0 size-[16px]" data-node-id="134:65" data-name="icon/signal">
            <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconSignal} />
          </div>
          <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.4] min-w-px relative text-[#6b4e00] text-[13px]" data-node-id="134:67">
            Weak signal? Switch to SMS
          </p>
          <a className="[word-break:break-word] block cursor-pointer font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[0] relative shrink-0 text-[#18181f] text-[13px] whitespace-nowrap" data-node-id="134:68">
            <p className="leading-[1.4]">Use SMS</p>
          </a>
        </div>
        <div className="bg-white border-[#ece8df] border-solid border-t content-stretch flex gap-[10px] items-center overflow-clip px-[16px] py-[12px] relative shrink-0 w-full" data-node-id="134:70" data-name="Composer">
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex items-center justify-center overflow-clip relative rounded-[20px] shrink-0 size-[40px]" data-node-id="134:71" data-name="Icon button">
            <div className="relative shrink-0 size-[18px]" data-node-id="134:72" data-name="icon/plus">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconPlus} />
            </div>
          </div>
          <div className="bg-[#fbf9f1] border border-[#ece8df] border-solid content-stretch flex flex-[1_0_0] h-[44px] items-center min-w-px overflow-clip px-[16px] relative rounded-[999px]" data-node-id="134:74" data-name="Container">
            <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.4] min-w-px relative text-[#a3a3ab] text-[14px]" data-node-id="134:75">
              Type a message…
            </p>
          </div>
          <div className="bg-[#febc20] content-stretch flex items-center justify-center overflow-clip relative rounded-[20px] shrink-0 size-[40px]" data-node-id="134:76" data-name="Icon button">
            <div className="relative shrink-0 size-[18px]" data-node-id="134:77" data-name="icon/send">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconSend} />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
