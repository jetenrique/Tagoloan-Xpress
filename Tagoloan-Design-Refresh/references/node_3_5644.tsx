const assetPathPrefix = "https://www.figma.com/api/mcp/asset/2a7cb07e-9486-4b6a-a680-9fb6f0409fb1";
const imgContainer = `${assetPathPrefix}/5f578.svg`;
const imgContainer1 = `${assetPathPrefix}/9812a.svg`;
const imgContainer2 = `${assetPathPrefix}/f1263.svg`;
const imgIconWifioff = `${assetPathPrefix}/bf3cc.svg`;
const imgIconMsg = `${assetPathPrefix}/8f028.svg`;
const imgIconChev = `${assetPathPrefix}/c080f.svg`;
const imgIconPhone = `${assetPathPrefix}/c0d13.svg`;
const imgIconMsg1 = `${assetPathPrefix}/53bf2.svg`;
const imgIconRefresh = `${assetPathPrefix}/a009c.svg`;

export default function SmsFallbackRiderView() {
  return (
    <div className="bg-[#fbf9f1] relative size-full" data-node-id="3:5644" data-name="SMS fallback rider view">
      <div className="absolute bg-[#fbf9f1] content-stretch flex flex-col h-[844px] items-start left-0 overflow-clip top-0 w-[390px]" data-node-id="134:288" data-name="Screen">
        <div className="content-stretch flex h-[24px] items-center justify-between px-[16px] relative shrink-0 w-full" data-node-id="134:289" data-name="Container">
          <div className="content-stretch flex flex-col items-start relative shrink-0" data-node-id="134:290" data-name="Container">
            <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:SemiBold'] font-semibold justify-center leading-[0] relative shrink-0 text-[#18181f] text-[11px] tracking-[0.5px] whitespace-nowrap" data-node-id="134:291">
              <p className="leading-[16px]">9:41</p>
            </div>
          </div>
          <div className="content-stretch flex gap-[4px] items-center relative shrink-0" data-node-id="134:292" data-name="Container">
            <div className="relative shrink-0 size-[11.667px]" data-node-id="134:293" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer} />
            </div>
            <div className="h-[9.917px] relative shrink-0 w-[14px]" data-node-id="134:295" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer1} />
            </div>
            <div className="h-[11.667px] relative shrink-0 w-[5.833px]" data-node-id="134:297" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer2} />
            </div>
          </div>
        </div>
        <div className="content-stretch flex items-center overflow-clip px-[16px] py-[8px] relative shrink-0 w-full" data-node-id="134:299" data-name="App bar">
          <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Bold'] font-bold leading-[1.4] min-w-px relative text-[#18181f] text-[18px]" data-node-id="134:300">
            Connection
          </p>
          <div className="bg-[#fdecec] content-stretch flex items-center overflow-clip px-[10px] py-[4px] relative rounded-[999px] shrink-0" data-node-id="134:301" data-name="Chip">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#d93b3b] text-[12px] whitespace-nowrap" data-node-id="134:302">
              Offline
            </p>
          </div>
        </div>
        <div className="content-stretch flex flex-[1_0_0] flex-col gap-[16px] items-start min-h-px overflow-clip px-[16px] py-[8px] relative w-full" data-node-id="134:303" data-name="Body">
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[6px] items-center overflow-clip p-[24px] relative rounded-[16px] shrink-0 w-full" data-node-id="134:304" data-name="Offline">
            <div className="bg-[#fdecec] content-stretch flex items-center justify-center overflow-clip relative rounded-[28px] shrink-0 size-[56px]" data-node-id="134:305" data-name="Container">
              <div className="relative shrink-0 size-[26px]" data-node-id="134:306" data-name="icon/wifioff">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconWifioff} />
              </div>
            </div>
            <div className="h-[6px] relative shrink-0 w-px" data-node-id="134:308" data-name="Spacer" />
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Bold'] font-bold leading-[1.4] min-w-full relative shrink-0 text-[#18181f] text-[20px] text-center w-[min-content]" data-node-id="134:309">{`You're offline`}</p>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.4] min-w-full relative shrink-0 text-[#6b6b73] text-[14px] text-center w-[min-content]" data-node-id="134:310">
              You can still reach the customer by text or call.
            </p>
            <div className="h-[6px] relative shrink-0 w-px" data-node-id="134:311" data-name="Spacer" />
            <div className="bg-[#f3f1ea] content-stretch flex items-center overflow-clip px-[10px] py-[4px] relative rounded-[999px] shrink-0" data-node-id="134:312" data-name="Chip">
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#6b6b73] text-[12px] whitespace-nowrap" data-node-id="134:313">
                #TGX-8921 · Minute Burger
              </p>
            </div>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col items-start overflow-clip px-[16px] py-[4px] relative rounded-[16px] shrink-0 w-full" data-node-id="134:314" data-name="Options">
            <a className="content-stretch cursor-pointer flex gap-[12px] items-center overflow-clip py-[14px] relative shrink-0 w-full" data-node-id="134:315" data-name="Option – SMS">
              <div className="bg-[#fff7e0] content-stretch flex items-center justify-center overflow-clip relative rounded-[12px] shrink-0 size-[40px]" data-node-id="134:316" data-name="Container">
                <div className="relative shrink-0 size-[18px]" data-node-id="134:317" data-name="icon/msg">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconMsg} />
                </div>
              </div>
              <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col gap-[2px] items-start leading-[1.4] min-w-px overflow-clip relative text-left" data-node-id="134:319" data-name="Container">
                <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] text-[15px] w-full" data-node-id="134:320">
                  Send SMS
                </p>
                <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="134:321">
                  Opens your phone’s messages
                </p>
              </div>
              <div className="relative shrink-0 size-[18px]" data-node-id="134:322" data-name="icon/chev">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconChev} />
              </div>
            </a>
            <div className="bg-[#ece8df] h-px relative shrink-0 w-full" data-node-id="134:325" data-name="Rectangle" />
            <div className="content-stretch flex gap-[12px] items-center overflow-clip py-[14px] relative shrink-0 w-full" data-node-id="134:326" data-name="Option – Call">
              <div className="bg-[#e6f5ec] content-stretch flex items-center justify-center overflow-clip relative rounded-[12px] shrink-0 size-[40px]" data-node-id="134:327" data-name="Container">
                <div className="relative shrink-0 size-[18px]" data-node-id="134:328" data-name="icon/phone">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconPhone} />
                </div>
              </div>
              <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col gap-[2px] items-start leading-[1.4] min-w-px overflow-clip relative" data-node-id="134:330" data-name="Container">
                <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] text-[15px] w-full" data-node-id="134:331">
                  Call customer
                </p>
                <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="134:332">
                  Uses your mobile network
                </p>
              </div>
              <div className="relative shrink-0 size-[18px]" data-node-id="134:333" data-name="icon/chev">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconChev} />
              </div>
            </div>
          </div>
          <div className="h-[100px] relative shrink-0 w-full" data-node-id="134:335" data-name="Flexible space" />
          <a className="bg-[#febc20] content-stretch cursor-pointer flex gap-[8px] items-center justify-center overflow-clip py-[15px] relative rounded-[14px] shrink-0 w-full" data-node-id="134:336" data-name="Button – Open SMS">
            <div className="relative shrink-0 size-[16px]" data-node-id="134:337" data-name="icon/msg">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconMsg1} />
            </div>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#18181f] text-[15px] text-left whitespace-nowrap" data-node-id="134:339">
              Open SMS
            </p>
          </a>
          <a className="bg-white border border-[#ece8df] border-solid content-stretch cursor-pointer flex gap-[8px] items-center justify-center overflow-clip py-[13px] relative rounded-[14px] shrink-0 w-full" data-node-id="134:341" data-name="Button – Retry connection">
            <div className="relative shrink-0 size-[16px]" data-node-id="134:342" data-name="icon/refresh">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconRefresh} />
            </div>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#18181f] text-[15px] text-left whitespace-nowrap" data-node-id="134:344">
              Retry connection
            </p>
          </a>
          <div className="h-[8px] relative shrink-0 w-px" data-node-id="134:346" data-name="Spacer" />
        </div>
      </div>
    </div>
  );
}
